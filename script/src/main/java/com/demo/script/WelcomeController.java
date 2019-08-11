package com.demo.script;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Member;
import java.util.Map;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController{

    // inject via application.properties
    @Value("${welcome.message}")
    private String message = "Hello World";

    @GetMapping("/script")
    public String welcome(
            @ModelAttribute("formData") FormData data,
            Map<String, Object> model,
            HttpServletRequest request) throws Exception {
        model.put("message", this.message);
        model.put("output", "");
        callScript();
        return "welcome";
    }

    @PostMapping("/execute")
    public String execute(
            @ModelAttribute("formData") FormData data,
            Map<String, Object> model,
            HttpServletRequest request) throws Exception {
        String radioSelected = request.getParameter("radio");
        String customCommand = request.getParameter("command");
        model.put("message", this.message);
        String output = executeScript1(radioSelected,customCommand);
        model.put("output","Output of execution : "+output);
        return "welcome";
    }

    private void callScript() throws Exception{
        String homeDirectory = System.getProperty("user.home");
        Process process;
/*        if (isWindows) {
            process = Runtime.getRuntime()
                    .exec(String.format("cmd.exe /c dir %s", homeDirectory));
        } else {*/
            process = Runtime.getRuntime()
                    .exec(String.format("sh -c ls %s", homeDirectory));
        //}
        StreamGobbler streamGobbler =
                new StreamGobbler (process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(Model model, Member member,
                             BindingResult result) {
        model.addAttribute("member", member);
        return "successMember";
    }

    private String executeScript1(String selected, String customCommand) throws Exception{
        ProcessBuilder processBuilder = new ProcessBuilder();

        if(selected.equals("date")){
            processBuilder.command("bash","-c","date +%D");
        }else if(selected.equals("time")){
            processBuilder.command("bash","-c","Time");
        }else if(selected.equals("list")){
            processBuilder.command("bash","-c","ls");
        }else{
            processBuilder.command("bash","-c",customCommand);
        }

        Process process = processBuilder.start();
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }
        System.out.println("Output : "+output);
        return output.toString();
    }

    private ProcessBuilder executeTime(){
        return new ProcessBuilder().command("bash","-c","time");
    }

}
