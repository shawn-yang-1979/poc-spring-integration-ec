# spring-integration-poc
This PoC is to be familiar with spring integration features.

Assume there are 3 systmes: online store (Store), order management system (OMS), and ERP (ERP).<br>
Build up a enterprise service bus (ESB) empowered by spring integration to connect 3 systems above without changing system interfaces of them.

Reference:
ERP provides SOAP Web Service
https://spring.io/guides/gs/producing-web-service/

OMS provides RESTful Web Service
https://spring.io/guides/gs/rest-service/

Store submit a form
https://spring.io/guides/gs/handling-form-submission/

Store consumes RESTful Web Service on ESB<br>
OMS consumes RESTful Web Service on ESB
https://spring.io/guides/gs/consuming-rest/

ESB integration reference doc and sample code
http://docs.spring.io/spring-integration/docs/4.2.5.RELEASE/reference/html/
https://github.com/spring-projects/spring-integration-samples

ESB connects Store-to-OMS
https://github.com/spring-projects/spring-integration-samples/tree/master/intermediate/rest-http
https://github.com/spring-projects/spring-integration-samples/tree/master/basic/http

ESB downloads payment attachments from email and save them on folder
https://github.com/spring-projects/spring-integration-samples/tree/master/intermediate/mail-attachments

Learn how to use logback (the default spring logging mechnism)
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-logging
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-configure-logback-for-logging

Common application properties
http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#common-application-properties