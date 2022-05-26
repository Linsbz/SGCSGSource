function renderColoredSelect(
    options = [{id:"1", name:"Example"}],
    replaceContent = true,
    root = "cs-container",
    defaultMessage = "Escolha uma opção",
    color = {color: "#fff", bgColor: "#141d37", effects: "#0a0e1b"},
    action = function () { return true; }
) {
    root = document.getElementById(root);
    var content = '<div class="colored-selector">';
    content = content+ '<span>' + defaultMessage + '<i class="ph-caret-down"></i></span>';
    content = content+ '<ul class="colored-selector-options">';        
    options.forEach(function name(e, i) {
        content = content + '<li attrSlct="'+e.id+'">'+e.name+'</li>';
    });
    content = content+ '</ul>';
    content = content+ '</div>';
    if(replaceContent === true) {
        root.innerHTML = content;
    }else {
        root.innerHTML = root.innerHTML + content;
    }
}