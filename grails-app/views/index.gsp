<!doctype html>
<html>
    <head>
        <title>Building Progressive UIs with Grails</title>
        <meta name="layout" content="main" />
        <r:use module="gr8"/>
    </head>
    <body>
        <section id="index">
            <nav id="examples">
                <h2>Examples:</h2>
                <ul>
                    <li>
                        Pagination
                        <ul>
                            <li><g:link controller="twitterSearch">Pagination -> Infinite scroll</g:link></li>
                            <li><g:link controller="list">Pagination -> AJAX enabled pagination</g:link></li>
                        </ul>
                    </li>
                    <li>
                        Forms
                        <ul>
                            <li><g:link controller="rating" action="album" id="1">Radio buttons -> Rating widget</g:link></li>
                        </ul>
                    </li>
                    <li>
                        Charts
                        <ul>
                            <li><g:link controller="twitterGraph" action="users">Table -> Bar chart</g:link></li>
                            <li><g:link controller="twitterGraph" action="clients">Table -> Pie chart</g:link></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </section>
    </body>
</html>
