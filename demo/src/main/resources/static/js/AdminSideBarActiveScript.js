


const aTagList = document.querySelectorAll('a.list-group-item');
const spanList = document.querySelectorAll('span.manager');


aTagList.forEach((item)=>{
    item.addEventListener('click', ()=>tagActiveAndLink(event));
});

spanList.forEach((item)=>{
    item.addEventListener('click', ()=>tagActive(event));
});

function tagActiveAndLink(event){
    const id = event.target.id;
    const className = event.target.className;


    if (event.target.tagName != 'A')
    return;


    if (className.includes("active")){
        event.target.classList.remove("active");
        return;
    }

    event.target.classList.add("active");
}

function tagActive(event){

    const parentElement = event.target.parentElement;

    // event.target.parentElement.className += " active";

    if (parentElement.className.includes("active")){
        parentElement.classList.remove("active");
        return;
    }


    parentElement.classList.add("active");
}

