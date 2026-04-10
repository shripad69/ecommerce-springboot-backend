# 🔐 CSRF (Cross-Site Request Forgery) — Complete Process Explained

---

## 📌 1. What is CSRF?

CSRF is an attack where a malicious website tricks a user's browser into sending an unauthorized request to another website where the user is already authenticated.

---

## ⚠️ 2. Why CSRF Exists (Root Cause)

### 🔑 Key Concept:
Browsers automatically attach cookies to every request.

**Example:**
```http
GET /profile
Cookie: sessionId=abc123
```

👉 Server trusts this cookie and assumes the request is from the logged-in user.

---

## 💥 3. CSRF Attack Flow (Step-by-Step)

### Step 1: User logs into a trusted site

Server generates:

```text
sessionId = abc123
```
Sends:
```http
Set-Cookie: sessionId=abc123
```
---
### Step 2: User visits malicious site (evil.com)
Attacker injects:
```html
<img src="https://bank.com/transfer?amount=1000&to=hacker" />
```
---
### Step 3: Browser sends request automatically
```http
GET /transfer?amount=1000&to=hacker
Cookie: sessionId=abc123
```
---
### ❌ Problem:
* Cookie is valid
* Request is accepted
* User did not intend this action 
---
## 🧠 4. Core Problem Summary 
| Issue | Explanation |
| -------------------- | ------------------------------------------ |
| Automatic cookies | Browser attaches them without user control |
| No intent validation | Server cannot verify if request is genuine |
| 
---


okay now in csrf we server generates an another token called csrf token, and client stores it in the browser in form of html and js  , now the attacker site can make a request from client site but it cannot read the html js fromt the client webpage hence it manually cannot sends the csrf token and hence the attack is prevented...