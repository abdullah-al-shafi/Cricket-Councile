
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/header.jsp"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form-group">
    <input type="text" class="form-control player-query"
           placeholder="Player Name">
</div>
<div
        class="btn btn-primary player-query-submit btn-lg btn-block">SEARCH</div>

<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Player Name</th>
        <th scope="col">Playing Role</th>
    </tr>
    </thead>
    <tbody class="search-result">

    </tbody>
</table>
<jsp:include page="../common/footer.jsp"/>
<script>
    $(document).ready(function(){
        $(".player-query-submit").click(function(){
            var queryString = $(".player-query").val();
            //   /api/v1/course/search | /course/search
            $.get("/api/v1/player/search?query="+queryString, function( data ) {
                var searchResContainer = $(".search-result");
                searchResContainer.html("");
                if (data.length > 0) {
                    $.each(data, function( index, value ) {
                        var tblRow = "<tr>\n" +
                            "        <td class='player-id'>"+ value.palyerId +"</td>\n" +
                            "        <td class='player-name'>"+ value.firstName + value.lastName + "</td>\n" +
                            "        <td class='player-Role'>"+ value.playingRole +"</td>\n" +
                            "    </tr>";
                        searchResContainer.append(tblRow);
                    });
                } else {
                    searchResContainer.html("<th >Nothing found!</th>");
                }
            });
        });
    });
</script>