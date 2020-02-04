<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainPage.css">
    <title>MAIN</title>
</head>
<body>
    <header>
        <jsp:include page="header.jsp" />
    </header>
    <main>
        <section class="about_races">
            <h3>The main thing about horse racing</h3>
            <p> Horse racing is part of equestrian sport, usually a competition involving two or more horses led 
                by jockeys (or sometimes without riders) at a certain distance for competition. Horse racing 
                is one of the oldest sports, since its main premise - to determine which of two or more 
                horses is the fastest at a given course or distance - has remained unchanged since ancient times.
            </p>
            <p> Horse racing varies in format, and many countries have developed their own special traditions. 
                Variations include limiting runs for specific breeds, running with obstacles, running at 
                different distances, running on different tracks, and running in different walks.
            </p> 
            <p> While part of the races is for sporting interest, a significant part of the races is related to 
                gambling, or other economic factors. In 2008, the global horse racing market amounted to about 115 
                billion US dollars. Due to the fact that horse racing is a competition of horses 
                and not riders, horse racing is not included in the equestrian program at the Olympic Games, 
                although the press often put forward proposals to recognize horse racing as an Olympic sport.
            </p>
            <p> The Hungarian horse mare Kinchem (born in 1874) is considered to be the most productive horse 
                ever involved in horse racing, having won 54 times unattainable for others in the 70s of the XIX 
                century and did not lose a single race. In second place after the Hungarian Kinchem in the ranking 
                of the invincible is the Australian horseback Black Caviar (born 2006) with 25 victories. 
                On the third - the American horse Peppers Pride (born 2003) with 19 victories.
            </p>
        </section>
    </main>
    <footer>
        <jsp:include page="footer.jsp" />
    </footer>
</body>
</html>