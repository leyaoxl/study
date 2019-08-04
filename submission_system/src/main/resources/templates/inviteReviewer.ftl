<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<#assign confirmLink = "http://${mailMap.hostAddress}/api/paper/reviewer/status?paperId=" + "${mailMap.paperId}" + "&reviewerId=" + "${mailMap.reviewerId}" + "&status=confirmed"/>
<#assign rejectLink = "http://${mailMap.hostAddress}/api/paper/reviewer/status?paperId=" + "${mailMap.paperId}" + "&reviewerId=" + "${mailMap.reviewerId}" + "&status=rejected"/>
<head>
    <meta charset="UTF-8">
    <title>Review Invite</title>
</head>
<body>
    <div>
        <span>
            <p>Dear ${mailMap.reviewerName}:</p>
            <p>First of all, thank you for being a member of our conference reviewer. The paper that you need to review are submitted to the ISEMC Submission System, and the abstract is displayed at the end of the email.</p>
            <p>Due to the upcoming conference and the short review period, we need you to confirm your participation in the review as soon as you receive the email.</p>
            <p>-------------------------------------------------------------</p>
            <p>*** After clicking on the link, you will confirm your participation in the review. ***</p>
            <p><a href="${confirmLink}">${confirmLink}</a></p>
            <p>*** After clicking on the link, you will confirm your rejection of the review. ***</p>
            <p><a href="${rejectLink}">${rejectLink}</a></p>
            <p>-------------------------------------------------------------</p>
            <p>The title：</p>
            <p>${mailMap.contributorTitle}</p>
            <p>-------------------------------------------------------------</p>
            <p>The abstract：</p>
            <p>${mailMap.contributorAbstract}</p>
            <p>-------------------------------------------------------------</p>
            <p>Best wishes</p>
            <p>ISEMC Submission System</p>
            <p>${mailMap.date}</p>
        </span>
    </div>
</body>
</html>