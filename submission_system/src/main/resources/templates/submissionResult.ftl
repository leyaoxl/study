<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Submission Result</title>
</head>
<body>
    <div>
        <span>
            <p>Dear ${mailMap.username}:</p>
            <p>Now we have received review comments from all reviewers on your paper.</p>
            <p>After a comprehensive analysis of all the review comments, the Technical Program Committee Chair decided that the submission result of your paper was <strong style="font-size: 20px">${mailMap.submissionResult}.</strong></p>
            <p>If the result is Accepted, congratulations!</p>
            <p>If the result is Rejected, don't be discouraged!</p>
            <p>-------------------------------------------------------------</p>
            <p>The following are some of the more representative review comments from reviewers:</p>
            <p>First reviewer：</p>
            <p>${mailMap.comment1}</p>
            <p>Second reviewer：</p>
            <p>${mailMap.comment2}</p>
            <p>Third reviewer：</p>
            <p>${mailMap.comment3}</p>
            <p>-------------------------------------------------------------</p>
            <p>Best wishes</p>
            <p>ISEMC Submission System</p>
            <p>${mailMap.date}</p>
        </span>
    </div>
</body>
</html>