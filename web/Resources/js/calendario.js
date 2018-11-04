
$(document).ready(function () {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    /*CALENDARIO DASHBOARD*/

    $('#calendar').fullCalendar({
        schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
        locale: 'es',
        themeSystem: 'bootstrap4',
        editable: true,
        eventLimit: true,
        navLinks: true,
        header: {
            left: 'today prev,next',
            center: 'title',
            right: 'timelineDay,timelineWeek'
        },
        
        defaultView: 'timelineDay',
        resourceGroupField: 'building',
        resources: [
            {id: 'a', building: '460 Bryant', title: 'Auditorium A'},
            {id: 'b', building: '460 Bryant', title: 'Auditorium B'},
            {id: 'c', building: '460 Bryant', title: 'Auditorium C'},
            {id: 'd', building: '460 Bryant', title: 'Auditorium D'},
            {id: 'e', building: '460 Bryant', title: 'Auditorium E'},
            {id: 'f', building: '460 Bryant', title: 'Auditorium F'},
            {id: 'g', building: '564 Pacific', title: 'Auditorium G'},
            {id: 'h', building: '564 Pacific', title: 'Auditorium H'},
            {id: 'i', building: '564 Pacific', title: 'Auditorium I'},
            {id: 'j', building: '564 Pacific', title: 'Auditorium J'},
            {id: 'k', building: '564 Pacific', title: 'Auditorium K'},
            {id: 'l', building: '564 Pacific', title: 'Auditorium L'},
            {id: 'm', building: '564 Pacific', title: 'Auditorium M'},
            {id: 'n', building: '564 Pacific', title: 'Auditorium N'},
            {id: 'o', building: '101 Main St', title: 'Auditorium O'},
            {id: 'p', building: '101 Main St', title: 'Auditorium P'},
            {id: 'q', building: '101 Main St', title: 'Auditorium Q'},
            {id: 'r', building: '101 Main St', title: 'Auditorium R'},
            {id: 's', building: '101 Main St', title: 'Auditorium S'},
            {id: 't', building: '101 Main St', title: 'Auditorium T'},
            {id: 'u', building: '101 Main St', title: 'Auditorium U'},
            {id: 'v', building: '101 Main St', title: 'Auditorium V'},
            {id: 'w', building: '101 Main St', title: 'Auditorium W'},
            {id: 'x', building: '101 Main St', title: 'Auditorium X'},
            {id: 'y', building: '101 Main St', title: 'Auditorium Y'},
            {id: 'z', building: '101 Main St', title: 'Auditorium Z'}
        ],
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb']
        
    });


    $('#calendarReservas').fullCalendar({
        schedulerLicenseKey: 'CC-Attribution-NonCommercial-NoDerivatives',
        locale: 'es',
        themeSystem: 'bootstrap4',
        defaultView: 'listWeek',

        // customize the button names,
        // otherwise they'd all just say "list"
        views: {
            listDay: {buttonText: 'list day'},
            listWeek: {buttonText: 'list week'},
            listMonth: {buttonText: 'list month'}
            
        },

        header: {
            left: '',
            center: 'title',
            right: ''
        },

        events: [
            {
                title:"Banda",
                start:"2018-07-12 10:00:00",
                end:"2018-07-12 12:00:00",
                
                
            }
            
        ]

    });
});

