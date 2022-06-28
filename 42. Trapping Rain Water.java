// my naive solution
// 188 ms, 47.3 MB
class Solution {
    public static int trap(int[] height) {
        if (height.length<2) return 0;
        int left = 0, right = height.length - 1;
        int water = 0;
        while (height[left] == 0 || (left + 1<= right && height[left + 1] >= height[left])) {
            left++;
        }
        while (height[right] == 0 || (right-1>=0 && height[right - 1] >= height[right])) {
            right--;
        }

        if (left == right) water = 0;

        int i = left;
        int start = i, end = i + 2, find1 = 0, maxRight = 0, maxRightID = 0;
        while (i <= right - 2) {
            find1 = 0;
            // find left side
            if (height[i] <= height[i + 1]) {
                i++;
            } 
            else {
                start = i;
            
            // find right edge
            maxRight = 0;
            maxRightID = 0;
            for (int j = start + 2; j <= right; j++) {
                if (height[j] >= height[start]) {
                    end = j;
                    find1 = 1;
                    break;
                }
                if (height[j] > height[j - 1]  & height[j] > maxRight) {
                    maxRight = height[j];
                    maxRightID = j;
                }

            }
            if (find1 != 1) {
                end = maxRightID;
            }
            if (end>start && end<=right) {
                // Since start and end are found, find the trapped water inside
                int waterheight = Math.min(height[start], height[end]);
                int totalArea = waterheight * (end - start + 1);
                int AreaToRemove = 0;
                for (int j = start; j <= end; j++) {
                    if (height[j] > waterheight) {
                        AreaToRemove = AreaToRemove + waterheight;
                    } else AreaToRemove = AreaToRemove + height[j];
                }
                water = water + totalArea - AreaToRemove;
            }
            i = end;
        }
        }
        return water;
    }
}


// 1ms
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length==0) return 0;
        
        int left =0, right = height.length-1;
        int maxLeft = 0, maxRight =0;
        
        int totalWater =0;
        
        while (left<right) {
            if (height[left]<height[right]) {
                if (height[left]>=maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
                } else {
                if (height[right]>=maxRight) {
                    maxRight = height[right];
                    
                } else {
                    totalWater +=maxRight - height[right];
                }
                right--;
            }
                
            }
        return totalWater;
        }
    }

// 1ms 
class Solution {
    public int trap(int[] height) {
        if (height.length<3) return 0;
        int ans = 0;
        int l=0, r = height.length -1;
        while (l<r && height[l]<=height[l+1])
            l++;
         while (l<r && height[r]<=height[r-1])
            r--;
        while (l<r) {
            int left = height[l];
            int right = height[r];
            
            if (left<right)
                while (l<r && left>=height[++l])
                    ans +=left - height[l];
            else
                while (l<r && height[--r]<=right)
                    ans +=right -height[r];
        }
        return ans;
        
    }


// 1ms

 if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0; int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0; int maxRight = 0;

        int totalWater = 0;
        while (left < right) {
            // Water could, potentially, fill everything from left to right, if there is nothing in between.
            if (height[left] < height[right]) {
                // If the current elevation is greater than the previous maximum, water cannot occupy that point at all.
                // However, we do know that everything from maxLeft to the current index, has been optimally filled, as we've
                // been adding water to the brim of the last maxLeft.
                if (height[left] >= maxLeft) {
                    // So, we say we've found a new maximum, and look to see how much water we can fill from this point on.
                    maxLeft = height[left];
                // If we've yet to find a maximum, we know that we can fill the current point with water up to the previous
                // maximum, as any more will overflow it. We also subtract the current height, as that is the elevation the
                // ground will be at.
                } else {
                    totalWater += maxLeft - height[left];
                }
                // Increment left, we'll now look at the next point.
                left++;
            // If the height at the left is NOT greater than height at the right, we cannot fill from left to right without over-
            // flowing; however, we do know that we could potentially fill from right to left, if there is nothing in between.
            } else {
                // Similarly to above, we see that we've found a height greater than the max, and cannot fill it whatsoever, but
                // everything before is optimally filled
                if (height[right] >= maxRight) {
                    // We can say we've found a new maximum and move on.
                    maxRight = height[right];
                // If we haven't found a greater elevation, we can fill the current elevation with maxRight - height[right]
                // water.
                } else {
                    totalWater += maxRight - height[right];
                }
                // Decrement left, we'll look at the next point.
                right--;
            }
        }
        // Return the sum we've been adding to.
        return totalWater;
