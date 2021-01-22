# Test scope bean of spring boot application

## Data

### Object Event

    This object is build for each 'http request'

### Object ID

    This object is creat for each call

### Object Counter

    This object is singleton, count Event and Id object creat

## Test

### Start application

    spring-boot:run

### Call Api

    curl --location --request POST 'http://localhost:8080/data/kiki'