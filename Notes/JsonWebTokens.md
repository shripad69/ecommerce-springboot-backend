1. Parts of the JWT  seperated by the 3 dots -


    a. header -> it has info of the encry algo used in the process
    b. payload -> it has the info of the user like username , password 
    c. encrypted text -> this is encryption result of the header and the payload 



2. process


    a. creation :
        1. server generates the header, and payload and it has JWT - SECRETE that is the key for the encry algo
           now it take the header and payload then encode it  and then  encryts it using that JWT-SECRETE which is only known to him 
        2. now it attaches the output to the the json at last after a . and sends to the user and user stores this token

    b. verify :
        1. now user sends the request with the token to the server  
        2. server takes the token and splits it into header , payload and encrypted part  
        3. server again takes the header and payload and encodes it  
        4. then using the same JWT-SECRETE it encrypts it again  
        5. now it compares the newly generated encrypted text with the encrypted text received in the token  
        6. if both are same then the token is valid and request is allowed  
    
    c. why csrf cannot happen here :
        1. in jwt authentication the token is not automatically attached by the browser in every request  
        2. unlike cookies, jwt is usually stored in localStorage or sessionStorage  
        3. when a request is sent, the client has to manually attach the token in the header like :
        Authorization: Bearer <token>  
        4. since browser does not automatically send this token, a malicious website cannot force the user’s browser to include the jwt  
        5. csrf attack works only when authentication data (like cookies) is automatically sent by the browser  
        6. in jwt flow, attacker cannot read or attach the token, so they cannot perform authenticated requests on behalf of the user  
        7. therefore csrf attack is not possible in this setup  




* why anyone cannot change the jwt (tamper scenarios and why they fail) :

1. attacker changes payload (ex: role = "admin")

   - attacker decodes the token (base64)
   - modifies payload
   - sends modified token

   why it fails :
   - signature is based on original header + payload
   - after change, signature becomes invalid
   - server recomputes signature and mismatch occurs → rejected  

---

2. attacker creates a completely new token

   - attacker makes their own header + payload
   - tries to generate signature

   why it fails :
   - attacker does not know JWT-SECRETE
   - cannot generate valid signature
   - server verification fails  

---

3. attacker copies someone else's token

   - attacker somehow gets another user’s token

   why it fails / limited :
   - it works ONLY if token is not expired and not protected
   - but generally mitigations exist:
     - short expiry time
     - https (prevents interception)
     - secure storage  

---

4. attacker changes header (algorithm etc)

   - modifies alg or other fields

   why it fails :
   - signature depends on header also
   - change → signature mismatch → rejected  

---

5. attacker tries brute force on secret

   why it fails :
   - strong secret key is used (long and random)
   - practically infeasible to guess  

---

6. attacker removes signature part

   - sends only header.payload

   why it fails :
   - server expects 3 parts
   - missing signature → invalid token  

---

7. attacker reuses expired token

   why it fails :
   - payload contains exp field
   - server checks expiry
   - expired → rejected  

---

8. attacker tries replay attack

   - sends same token again and again

   why it fails / mitigated :
   - short expiry
   - refresh tokens
   - sometimes server-side blacklisting  

---

final idea :

- jwt is not protected by secrecy of data  
- it is protected by integrity using signature  
- any change in header or payload breaks signature  
- without JWT-SECRETE, attacker cannot create valid token  