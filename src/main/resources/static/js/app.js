const navSlide = () => {
    const burger = document.querySelector('.burger');
    const nav = document.querySelector('.nav-links');

    burger.addEventListener('click', ()=> {
        nav.classList.toggle('nav-action');

        burger.classList.toggle('toggle');
    });
}

const aniBanner = () => {
    // var layer1 = document.getElementById('layer1')
    // scroll = window.pageYOffset;
    // document.addEventListener('scroll', function(e){
    //     var offset = window.pageYOffset;
    //     scroll = offset;
    //     // layer1.style.width = (100 + scroll/50) + '%';
    //     // layer1.style.height = (100 + scroll/50) + '%';
    //     layer1.style.left = scroll/40 + '%';
    //     layer2.style.bottom = scroll/20 + '%';

    // })

    // var layer2 = document.getElementById('layer2')
    // scroll = window.pageYOffset;
    // document.addEventListener('scroll', function(e){
    //     var offset = window.pageYOffset;
    //     scroll = offset;
    //     layer2.style.right = scroll/40 + '%';
    //     layer2.style.top = scroll/1000 + '%';

    // })

    var text = document.getElementById('text')
    scroll = window.pageYOffset;
    document.addEventListener('scroll', function(e){
        var offset = window.pageYOffset;
        scroll = offset;
        text.style.top = scroll/10 + '%';
        // layer1.style.opacity = -(scroll/2000)+1
        // layer2.style.opacity = -(scroll/2000)+1
        // console.log(-(scroll/2000)+1)
    })
}


const app = () => {
    navSlide();
    aniBanner();
}

app();