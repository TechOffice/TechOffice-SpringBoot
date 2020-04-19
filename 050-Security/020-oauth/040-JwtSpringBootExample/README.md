JWT Example

It is an example which would try to use two Authentication Processing Filter, 
i.e. **JwtUsernamePasswordAuthenticationFilter** and **JwtTokenAuthenticationFilter**, to test with jwt token login

## JwtUsernamePasswordAuthenticationFilter
It would validate the user and password. if success, it would attach jwt token to response header.

## JwtTokenAuthenticationFilter
It would validate the jwt token.

home page: http://localhost:8080/
user name: user
password: password

submit with success
    