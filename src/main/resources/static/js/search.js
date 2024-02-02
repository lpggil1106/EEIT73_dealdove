let url = new URL(window.location.href)
let keyword = url.searchParams.get('keyword')
let search = document.querySelector('.search-input')
let searchIcon = document.querySelector('.search-icon')
if (keyword) {
    search.value = keyword
}

search.addEventListener('keyup', (e) => {
    //keykode 13 是 enter
    if (e.keyCode === 13) {
        let keyword = search.value
        window.location.href = `./productHome?keyword=${keyword}`
    }
})

searchIcon.addEventListener('click', () => {
    let keyword = search.value
    window.location.href = `./productHome?keyword=${keyword}`
})