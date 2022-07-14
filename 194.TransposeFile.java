// s1
// 65%, 25%
cat file.txt | awk '{for (f=1;f<=NF;f++) col[f] = col[f]":"$f} END {for (f=1;f<=NF;f++) print substr(col[f],2)}' | tr ':' ' '
