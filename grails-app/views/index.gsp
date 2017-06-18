<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Project Email Marketing</title>

<%--    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />--%>
		<asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
	<content tag="nav">
    	<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
    		<li class="dropdown">    			
    			<g:if test="${c.fullName.split("springsecurity")[0] != 'grails.plugin.'}"> --%>
    				<a href="${c.logicalPropertyName}">${(c.fullName.split("Controller")[0]).split("marketblastapp.")[1]}</a></g:if>
			</li>
		</g:each>
									    		
<%-- shortName    		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>--%>
<%--           	<ul class="dropdown-menu">--%>
<%--           	<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--%>
<%--            	<li class="controller">--%>
<%--            	<li>--%>
<%--            		<a href="${c.logicalPropertyName}">${c.fullName}</a>--%>
<%--                	<g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>--%>
<%--                </li>--%>
<%--            </g:each>--%>
                    
<%--            <li class="dropdown">--%>
<%--            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Application Status <span class="caret"></span></a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--                <li><a href="#">Environment: ${grails.util.Environment.current.name}</a></li>--%>
<%--                <li><a href="#">App profile: ${grailsApplication.config.grails?.profile}</a></li>--%>
<%--                <li><a href="#">App version:--%>
<%--                    <g:meta name="info.app.version"/></a>--%>
<%--                </li>--%>
<%--                <li role="separator" class="divider"></li>--%>
<%--                <li><a href="#">Grails version:--%>
<%--                    <g:meta name="info.app.grailsVersion"/></a>--%>
<%--                </li>--%>
<%--                <li><a href="#">Groovy version: ${GroovySystem.getVersion()}</a></li>--%>
<%--                <li><a href="#">JVM version: ${System.getProperty('java.version')}</a></li>--%>
<%--                <li role="separator" class="divider"></li>--%>
<%--                <li><a href="#">Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</a></li>--%>
<%--            </ul>--%>
<%--        </li>--%>
<%--        <li class="dropdown">--%>
<%--            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Artefacts <span class="caret"></span></a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--                <li><a href="#">Controllers: ${grailsApplication.controllerClasses.size()}</a></li>--%>
<%--                <li><a href="#">Domains: ${grailsApplication.domainClasses.size()}</a></li>--%>
<%--                <li><a href="#">Services: ${grailsApplication.serviceClasses.size()}</a></li>--%>
<%--                <li><a href="#">Tag Libraries: ${grailsApplication.tagLibClasses.size()}</a></li>--%>
<%--            </ul>--%>
<%--        </li>--%>
<%--        <li class="dropdown">--%>
<%--            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Installed Plugins <span class="caret"></span></a>--%>
<%--            <ul class="dropdown-menu">--%>
<%--                <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">--%>
<%--                    <li><a href="#">${plugin.name} - ${plugin.version}</a></li>--%>
<%--                </g:each>--%>
<%--            </ul>--%>
<%--        </li>--%>
    </content>

    <div class="svg" role="presentation">
        <div class="grails-logo-container">
            <%-- <asset:image src="grails-cupsonly-logo-white.svg" class="grails-logo"/> --%>
            <%-- <asset:image src="b5.svg" class="grails-logo"/> --%>
        </div>
    </div>
	
    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Welcome to Project MarketBlast!</h1>

            <p>
				Project MarketBlast is an email marketing system that enables organizations to promote their business by connecting with their clients and attracting new prospects.
				My role is a full stack developer on this project. I worked on all phases of development including system analysis, database design, software development, testing and deployment/delivery.
            </p>

<%--            <div id="controllers" role="navigation">--%>
<%--                <h2>Available Controllers:</h2>--%>
<%--                <ul>--%>
<%--                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--%>
<%--                        <li class="controller">--%>
<%--                            <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>--%>
<%--                        </li>--%>
<%--                    </g:each>--%>
<%--                </ul>--%>
<%--            </div>--%>
        </section>
    </div>

</body>
</html>
