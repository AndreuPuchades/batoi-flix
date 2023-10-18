document.querySelectorAll('.carousel').forEach(carousel => {
    const carouselInner = carousel.querySelector('.carousel-inner');
    const prevButton = carousel.querySelector('.prev-button');
    const nextButton = carousel.querySelector('.next-button');
    const slideWidth = carouselInner.clientWidth / 5;
    const totalSlides = carouselInner.children.length;
    let currentPosition = 0;

    prevButton.addEventListener('click', () => {
        if (carousel.id === 'carouselExampleControls' || carousel.id === 'carouselExampleControls2') {
            currentPosition += slideWidth * 5;
            if (currentPosition > slideWidth) {
                currentPosition = 0;
            }
        } else {
            currentPosition += slideWidth;
            if (currentPosition > 0) {
                currentPosition = -slideWidth * (totalSlides - 5);
            }
        }
        carouselInner.style.transform = `translateX(${currentPosition}px)`;
    });

    nextButton.addEventListener('click', () => {
        if (carousel.id === 'carouselExampleControls'|| carousel.id === 'carouselExampleControls2') {
            currentPosition -= slideWidth * 5;
            if (currentPosition < -slideWidth * (totalSlides - 5)) {
                currentPosition = -slideWidth * (totalSlides - 1);
            }
        } else {
            currentPosition -= slideWidth;
            if (currentPosition < -slideWidth * 5) {
                currentPosition = 0;
            }
        }
        carouselInner.style.transform = `translateX(${currentPosition}px)`;
    });
});
