<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
    <head>

        <!-- Access the bootstrap Css like this,
            Spring boot will handle the resource mapping automcatically -->
        <!--link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>

    <body>
        <div class="container">
            <div class="starter-template">
                <h1>Script Executor</h1>
                <h2>Message: ${message}</h2>
            </div>

            <form method="POST" action="execute" commandName="data">
                <div class="radio">
                    <input type="radio" id="1" name="radio" value="list">&nbsp;List Directory</input> <br>
                    <input type="radio" id="2" name="radio" value="date">&nbsp;Print Date</input> <br>
                    <input type="radio" id="3" name="radio" value="time">&nbsp;Print Time</input> <br>
                    <input type="radio" id="4" name="radio" value="command">&nbsp;Command :&nbsp</input>
                    <input type="text" name="command"></input> <br>
                    <br>


                </div>
                <input type = "submit" value = "Submit"/>

                <textarea rows="4" cols="50" >${output}</textarea>
            </form>
        </div>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>