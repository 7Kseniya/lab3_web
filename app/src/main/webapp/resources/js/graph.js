function createRectangle(board, r) {
    let rectanglePoint1 = board.create('point', [0, 0], {name: '', fixed: true, visible: false});
    let rectanglePoint2 = board.create('point', [-r, 0], {name: '', fixed: true, visible: false});
    let rectanglePoint3 = board.create('point', [-r, r], {name: '', fixed: true, visible: false});
    let rectanglePoint4 = board.create('point', [0, r], {name: '', fixed: true, visible: false});
    return board.create('polygon', [rectanglePoint1, rectanglePoint2, rectanglePoint3, rectanglePoint4],
        {
            fillColor: '#666b61', 
            fillOpacity: 1
        });
}

function createTriangle(board, r) {
    let trianglePoint1 = board.create('point', [0, 0], {name: '', fixed: true, visible: false});
    let trianglePoint2 = board.create('point', [r / 2, 0], {name: '', fixed: true, visible: false});
    let trianglePoint3 = board.create('point', [0, -r / 2], {name: '', fixed: true, visible: false});
    return board.create('polygon', [trianglePoint1, trianglePoint2, trianglePoint3], 
    {
        fillColor: '#666b61',
        fillOpacity: 1
    });
}

function createCircle(board, r) {
    let circlePoint1 = board.create('point', [0, r], {name: '', fixed: true, visible: false});
    let circlePoint2 = board.create('point', [r, 0], {name: '', fixed: true, visible: false});
    let centerPoint = board.create('point', [0, 0], {name: '', fixed: true, visible: false});

    return board.create('sector', [centerPoint, circlePoint2, circlePoint1],
    {
        fillColor: '#666b61', 
        fillOpacity: 1
    });
}

function clearFigures(board, drawnObjects) {
    for (const object of drawnObjects) {
        let points = object.ancestors;
        for (const point in points) board.removeObject(point);
        board.removeObject(object);
    }
}

function clearPoints() {
    for (const point of points) {
        board.removeObject(point);
    }
    points = []
}

function drawPointsByR(r) {
    for (let i = 0; i < serverPoints.length; i++) {
        let serverPoint = serverPoints[i];
        console.log(r + " " + serverPoint.r + " " + (parseFloat(r) === serverPoint.r) + " " + serverPoint.hit)
        if (parseFloat(r) === serverPoint.r) {
            let point = createPoint(board, serverPoint.x, serverPoint.y, serverPoint.hit);
            points.push(point);
        }
    }
}
function createPoint(board, x, y, hit) {
    let color = hit ? "#178817" : "#a90e0e";
    return board.create("point", [x, y], {name: '', fixed: true, fillColor: color, fillOpacity: 1,
    strokewidth: 0});
}