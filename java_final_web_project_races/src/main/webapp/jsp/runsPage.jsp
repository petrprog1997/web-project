<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/runsPage.css">
    <title>Document</title>
</head>
<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>
    <main>
        <section class="runs">
            
            <section class="run_list">
                <h3>Runs</h3>
                <c:forEach var="run" items="${runList}">
                    <section class="run">
                        <section class="run_data">
                            <span>${run.runId}</span>
                            <span>${run.runDate}</span>
                            <span>${run.runStatus}</span>
                            <span>${run.runWinner}</span>
                        </section>
                        <c:forEach var="runParticipantItem" items="${runParticipants}">
                            <c:if test="${run.runId == runParticipantItem.runId}">
                                <section class="run_participants">
                                    <span>${runParticipantItem.horseName}</span>
                                    <span>${runParticipantItem.runNumber}</span>
                                    <span>${runParticipantItem.runPlace}</span>
                                    <span>${runParticipantItem.runId}</span>
                                </section>
                            </c:if>
                        </c:forEach>
                    </section>
                </c:forEach>  
            </section>


        <c:if test="${role == 'ADMINISTRATOR'}">
            <section class="add_run">
                <section class="add_run_form">
                    <h3>Add run</h3>
                    <form name="run-form" method="post" action="controller">
                
                        <input type="hidden" name="command" value="addRun" />
                        
                        <section class="date">
                            <label for="date">Enter run date</label>
                            <input id="date" type="text" name="date"/>
                            <input type="submit" value="Add run">
                        </section>
                    </form>
                </section>
                <section class="add_run_participants">
                    <h4>Run Participants</h4>
                    <section class="run_participants">
                        <form name="run_participants_form" method="post" action="controller">
                            <input type="hidden" name="command" value="addRunParticipant">
                    
                            <label for="runId">Add run participants for run</label>
                            <input type="text" name="runId" id="runId">

                            <c:forEach var="raceParticipant" items="${raceParticipants}">
                                <section class="run_participant">
                                    <input type="checkbox" name="raceParticipant" id="${raceParticipant.getRunNumber()}" value="${raceParticipant}"> 
                                    <label for = "${raceParticipant.getRunNumber()}">
                                        <span>Participant №${raceParticipant.getRunNumber()},<span>
                                        <span>with horse name ${raceParticipant.getHorseName()}<span>
                                    </label>
                                </section>
                            </c:forEach>
                        
                            <input type="submit" value="Add run participant">
                        </form>
                    </section>    
                </section>
                <section class="delete_run">
                    <form name="delete_run_form" method="post" action="controller">
                        <input type="hidden" name="command" value="deleteRun">
                        <label for="runId">Input run id</label>
                        <input type="text" name="runId" id="runId">
                        <input type="submit" value="Delete run">
                    </form>
                </section>
            </section>
 
        </c:if>
    </section>
    </main>

    <footer>
     <jsp:include page="footer.jsp" />
    </footer>
</body>