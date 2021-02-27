#!/usr/bin/env bash



  HTTPD=`curl -A "Web Check" -sL --connect-timeout 3 -w "%{http_code}\n" "http://product-service:8080/api/v1/products/" -o /dev/null`
  printf $HTTPD
  until [ "$HTTPD" == "200" ]; do
    printf $HTTPD
    sleep 3
    HTTPD=`curl -A "Web Check" -sL --connect-timeout 3 -w "%{http_code}\n" "http://product-service:8080/api/v1/products/" -o /dev/null`
  done
  sleep 5

java -jar order-service.jar
