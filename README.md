## Microservices

#### Topic - Retry(Resilience 4J)

-**Where is use?**

suppose once of the serveice is down and we don't want to do unceesary service calls or if we don't know service is down and 
we want to give some limit of retrying the calls. We can set the limit of retry.

-**How is use in code?**

we use in the level of controller with  @GetMapping or we can use with other  rest api annotation. use syntax @Retry(name="retryName",fallbackmethod="fallbackMethod")
other implimentation in code. add below configuration in application file.

resilience4j:
      retry:
        instances:
          ratingUserRetry:
            max-attempts: 3
            wait-duration: 5s

for more learning read the documentation
<https://resilience4j.readme.io/docs/retry>

#### Topic - Rate limit(Resilience 4J)

This functionality allow limiting access to some servies.

Rate limiter make services highly available by limiting the number of calls we could process in specific windows\perticular time limit.

Align with service objectives: Clearly define the goals of rate limiting in each microservice to guide appropriate configuration.
Start conservative: Begin with moderate limits and gradually adjust them based on monitoring and analysis.
Provide clear feedback: Inform clients about rate limits through error messages or API documentation to enhance transparency and prevent frustration.
Consider dynamic adjustments: Explore approaches to dynamically adapt rate limits based on factors like real-time resource availability or user behavior.
Test and fine-tune: Thoroughly test rate limiting implementations to ensure they work as intended and avoid unintended consequences.





