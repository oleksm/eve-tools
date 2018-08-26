<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title><g:message message="Moon Probe and Analysis" /></title>
</head>
<body>

<style>
textarea {
    width: 640px;
    height: 480px;
}
</style>
<div class="message" role="status">${flash.message}</div>
<div id="list-moonmaterial" class="content scaffold-list" role="main" align="center">
    <h1><g:message message="Paste results from EVE here:" /></h1>
    <br/>
    <g:form controller="moonmaterial">
        <g:textArea name="text_data" rows="20" cols="80"/>
        <br/><br/>
        <g:actionSubmit value="Submit" action="import_submit"/>
    </g:form>
</div>
</body>
</html>