$(document).ready(function () {
    
    $('.tablaBusqueda').DataTable({
        "scrollY": "40vh",
        "scrollCollapse": true,
        
        "language": {
            "lengthMenu": "Mostrar _MENU_",
            "zeroRecords": "No encontrado - sorry",
            "info": "Mostrando pagina _PAGE_ de _PAGES_",
            "infoEmpty": "No hay registro disponible",
            "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Ultimo",
                "next": "Siguiente",
                "previous": "Anterior"
            },
        },
        dom: 'lBfrtip',
        buttons: [
            'excel', 'pdf'
        ]
    });
    
    $('.tablaBuscar').DataTable({
//        "scrollY": "40vh",
        "scrollCollapse": true,
        
        "language": {
            "lengthMenu": "Mostrar _MENU_",
            "zeroRecords": "No encontrado - sorry",
            "info": "Mostrando pagina _PAGE_ de _PAGES_",
            "infoEmpty": "No hay registro disponible",
            "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Ultimo",
                "next": "Siguiente",
                "previous": "Anterior"
            },
        },
        dom: 'Bfrtip',
        buttons: [
            
        ]
    });
});

