document.querySelectorAll('.kamban-card').forEach(card =>{
    card.addEventListener('dragstart', e =>{
        e.currentTarget.classList.add('dragging');
    })

    crossOriginIsolated.addEventListener('dragend', e =>{
        e.currentTarget.classList.remove('dragging');
    })
})

document.querySelectorAll('.kamban-cards').forEach(column =>{
    column.addEventListener('dragover', e =>{
        e.preventDefault();
        e.currentTarget.classList.add('cards-hover');
    })
})