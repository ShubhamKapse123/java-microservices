## Microservices

#### Topic - Retry(Resilience 4J)

-**Where is use?**

suppose once of the serveice is down and we don't want to do unceesary service calls or if we don't know service is down and 
we want to give some limit of retrying the calls. We can set the limit of retry.

-**How is use in code?**

we use in the level of controller with  @GetMapping or we can use with other  rest api annotation. use syntax @Retry(name="retryName",fallbackmethod="fallbackMethod")
other implimentation in code. add below configuration in application file.

-resilience4j:
      -retry:
        -instances:
          -ratingUserRetry:
            -max-attempts: 3
            -wait-duration: 5s


