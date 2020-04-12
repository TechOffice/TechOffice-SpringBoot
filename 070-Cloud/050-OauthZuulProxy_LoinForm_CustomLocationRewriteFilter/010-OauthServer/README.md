
* /oauth/authorize (authorization endpoint)
* /oauth/token (token endpoint)
* /oauth/confirm_access (user posts approval for grants here)
* /oauth/error (used to render errors in the authorization server)
* /oauth/check_token (used by Resource Servers to decode access tokens)
* /oauth/token_key (exposes public key for token verification if using JWT tokens)

## Reference
* https://projects.spring.io/spring-security-oauth/docs/oauth2.html

## Example

```
curl client:secret@localhost:8080/oauth/token -d grant_type=password -d username=user -d password=password
```

```
curl user:password@localhost:8080/oauth/check_token/?token=16a9bd57-9951-4e29-bff2-3872e1388a00
```