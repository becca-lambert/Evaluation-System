 <html>
<head>
 <jsp:include page="headerEm.jsp"/>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
 
      google.charts.load('current', {'packages':['line']});
      google.charts.setOnLoadCallback(drawChart);

    function drawChart() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Sales (£) Monday - Friday ');
      data.addColumn('number', 'Current Week');
      data.addColumn('number', 'Previous Week');
      data.addColumn('number', 'Adverage Week');
      data.addRows([
        [1, 600, 643, 555],
        [2,  350, 300, 300],
        [3,  230, 500, 700],
        [4,  200, 200, 200],
        [5,  550, 500, 480],
 
      ]);

      var options = {
        chart: {
          title: 'Total sales per Day- Chandler Bing',
          subtitle: 'in British Pounts £ (GBP)'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }
  </script>

</head>
<body>
  <div id="line_top_x"></div>
</body>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Month', 'Complaints'],
          ['JAN', 2],
          ['FEB', 1]
       
        ]);

        var options = {
          chart: {
            title: 'Company Performance',
            subtitle: 'Chandler bing',
          },
          bars: 'horizontal' // Required for Material Bar Charts.
        };

        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      }
    </script>
  </head>
  <body>
    <div id="barchart_material" style="width: 900px; height: 500px;"></div>
  </body>
  
 <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Clocking In time', 'percentage '],
          ['Lates',     0],
          ['On Time',      9],
          ['Late within 10 mins',  1],
         
        ]);


      var options = {
        legend: 'none',
        pieSliceText: 'label',
        title: 'Clocking in Times ',
        pieStartAngle: 100,
      };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
  </body>
    <body>
        
        <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Name');
        data.addColumn('string', 'Attitude');
        data.addColumn('string', 'Time Management');
        data.addColumn('string', 'Punctuality');
        data.addColumn('string', 'Management Relations');
       
       
        data.addRows([
          ['Chandler Bing', "15/20", "19/20", "17/20","20/20"],
         
        ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
    </script>
  </head>
  <body>
    <div id="table_div"></div>
  </body>

        </body>
</html>

