/*
Count number of islands - groups of 1s
*/
/**
 * @param {character[][]} grid
 * @return {number}
 */
const numIslands = function(grid) {
    
    let numIslands = 0;
    
    for(let i=0; i<grid.length; i++) {
        for(let j=0;j<grid[i].length;j++) {
            if (grid[i][j] === '1'){
                // do DFS
                DFSearch(grid,i,j);
                // add to islands
                numIslands += 1;
            }
        }
    }
    
    return numIslands;
};

function DFSearch(grid,i,j) {
    if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) {
        return;
    }
    
    if (grid[i][j] === '0' || grid[i][j] === '#') {
        return;
    } 
    
    grid[i][j] = '#';
    
    DFSearch(grid,i+1,j);
    DFSearch(grid,i-1,j);
    DFSearch(grid,i,j+1);
    DFSearch(grid,i,j-1);
    
    return;
}
