function searchStudent() {
    var searchBar, filter, list, elementFromList, span, i, txtValue;

    searchBar = document.querySelector('#studentSearchBar');
    filter = searchBar.value.toUpperCase();
    list = document.querySelector(".list-click--borderless");
    elementFromList = list.getElementsByTagName("a");

    for (i = 0; i < elementFromList.length; i++) {

        span = elementFromList[i].getElementsByTagName("span")[0];
        txtValue = span.textContent || span.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            elementFromList[i].style.display = "";
        } else {
            elementFromList[i].style.display = "none";
        }
    }
}

if (document.getElementById("courseSelect") != null)
{
    let course ;
    document.querySelector("#courseSelect").addEventListener("change",() =>{
        course = document.getElementById("courseSelect").selectedOptions[0].value
        assoCouse(course)
    });

 //   assoCouse(course ,etudiant)
}

function assoCouse(course){
    if (course != null  )
    {
        let etudiant = document.querySelector("#spanStudent").value;
        console.log(course +" "+ etudiant)
        document.getElementById("linkCourseToStudentAction").setAttribute("value",course +" "+ etudiant)
    }
}


if (document.getElementById("courseSelect") != null)
{
    let course ;
    document.querySelector("#courseSelect").addEventListener("change",() =>{
        course = document.getElementById("courseSelect").selectedOptions[0].value
        assoCouse(course)
    });

 //   assoCouse(course ,etudiant)
}

function assoCouse(course){
    if (course != null  )
    {
        let etudiant = document.querySelector("#spanStudent").value;
        console.log(course +" "+ etudiant)
        document.getElementById("linkCourseToStudentAction").setAttribute("value",course +" "+ etudiant)
    }
}

/**/
