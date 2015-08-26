<html>
<body>
    <form role="form" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="email">Email address</label>
            <input type="email" name="email" id="email" required autofocus />
        </div>
        <div>
            <label for="password">Password</label>
            <input type="password" name="password" id="password" required />
        </div>
        <div>
            <label for="remember-me">Remember me</label>
            <input type="checkbox" name="remember-me" id="remember-me" />
        </div>
        <button type="submit">Sign in</button>
    </form>
</body>
</html>