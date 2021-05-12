document.querySelector(".button-submit").addEventListener('click',() => {
    formStudentValidator();
});

function formStudentValidator(){

    person = {
        prenom : document.querySelector('#prenom').value,
        nom : document.querySelector('#nom').value,
        adresse : document.querySelector('#adresse').value,
        telephone : document.querySelector('#telephone').value,
        naissance : document.querySelector('#naissance').value,
        email : document.querySelector('#email').value,
    }

    if(!person.prenom || !person.nom || !person.adresse || !person.telephone || !person.naissance || !person.email){
    document.querySelector(".error-manager").style.display = "block";
    document.querySelector('#error-manager-list').innerHTML = "";

    for(const property in person){
        if(person[property] == "" || person[property] == null){
            console.log(property + " is empty.");
            document.querySelector('#error-manager-list').innerHTML += "<li>Le champs " + property +" doit être rempli</li>";
        }
    }

 } else {
    document.querySelector(".error-manager").style.display = "none";
    alert(person.prenom + " " +  person.nom + " a bien été inscrit.");
 }
}


class Person{
    constructor(id, prenom, nom, adresse, telephone, naissance, email){
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.naissance = naissance;
        this.email = email;
    }
}

var listPerson = [
    new Person(1, "Jean", "Claude", "1 rue des champs", 0631313131, null, "jm@jjm.jm"),
    new Person(2, "Jean", "Jacques", "2 avenue du pré", 0612345, null, "jeancloclo@yop.jc"),
    new Person(3, "Jean", "Patrick", "54 route de la plage", 08070943, null, "patoche@pat.france"),
    new Person(4, "Jean", "Marc", "25 rue des bruyères", 08541325, null, "marco@yopmail.com"),
]

window.addEventListener('load',() => {
    populateSelectStudent();
});

function populateSelectStudent(){
    listPerson.forEach(element => {
        document.querySelector('#selectStudent').innerHTML += "<option value='"+element.id+"'>"+ element.prenom +" " +element.nom+ "</option>";
    })
}

document.querySelector("#selectStudent").addEventListener('change',() => {
    populateStudentForm();
});

function populateStudentForm(){
    var valo = document.querySelector('select').value - 1;
    console.log(listPerson[valo]);
    document.querySelector('#prenom').value = listPerson[valo].prenom
    document.querySelector('#nom').value = listPerson[valo].nom
    document.querySelector('#adresse').value = listPerson[valo].adresse
    document.querySelector('#telephone').value = listPerson[valo].telephone
    document.querySelector('#naissance').value = listPerson[valo].naissance
    document.querySelector('#email').value = listPerson[valo].email

}