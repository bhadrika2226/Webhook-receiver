<h1>Webhook-Receiver_Project</h1><br>

<h3>A Spring Boot application to receive and batch-process webhook payloads.</h3><br>

<h4>Features include:</h4><br>

GET http://localhost/8080/api/healthz: Health check endpoint.
(succesful redirection will give status 200 with msg OK)<br>
POST http://localhost/8080/api/log : Accepts JSON payloads, batches them, and forwards to an external endpoint.
<br>
(headers:<br>
    conent-type:application/json<br>
   <pre>example : body:{
            {
            "userId": 1,
            "total": 1.65,
            "title": "Test Title",
            "meta": {},
            "completed": false
            }
    }</pre><br>
(successful redirection of payloads will give status of 200 with msg payloads received!! and the batch size will be printed on the console window of the run environment)
<br>

<h4>Configuration</h4><br>
Set environment variables or modify application.properties:<br>
<pre>
batch.size: default: 10.
batch.interval: (in milliseconds) 3000.
post.endpoint:http://localhost:8080/api/log.</pre>
<br>

here i have used the dependencies like <br>
    <b>spring-starter-web</b> for the restful communication<br>
        also it provides the scheduling logic as a inbuilt functionality<br>
    for the logging purpose i have used the <b>spring-boot-stater-logging</b><br>


    