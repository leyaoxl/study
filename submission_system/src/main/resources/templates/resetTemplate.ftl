<!DOCTYPE html>
<html>
<#assign resetUrl = "http://${mailMap.hostAddress}/newPassword?safeUserId=" + "${mailMap.safeUserId}"/>
<#--<#assign resetUrl = "http://10.128.193.119:8888/#/newPassword?safeUserId=" + "${mailMap.safeUserId}"/>-->
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
</head>
<body>
    <div>
        <p>Dear ${mailMap.username}:</p>
        <p>-------------------------------------------------------------</p>
        <p>Your email address:<B>${mailMap.email}</B></p>
        Please click this link to reset your login password, which will direct you to set a new password.
        <p><a href="${resetUrl}">${resetUrl}</a></p>
        <p>-------------------------------------------------------------</p>
        <p>Best wishes</p>
        <p>ISEMC Submission System</p>
        <p>${mailMap.date}</p>
    </div>
</body>
</html>