//1: use indexOf()
function findNeedle(haystack) {
    // your code here
    let index = haystack.indexOf("needle");
    return index!==-1 ? `found the needle at position ${index}` : "needle not found";
  }