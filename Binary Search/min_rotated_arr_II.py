def findMin(nums):
    l, r = 0, len(nums) - 1
    while l < r:
        mid = (l + r) // 2
        if nums[l] == nums[mid] == nums[r]:
            l += 1
            r -= 1
        
        elif nums[l] <= nums[mid]:
            if nums[r] <= nums[l]:
                l = mid + 1
            else:
                r = mid
        else:
            if nums[mid] <= nums[r]:
                r = mid
            else:
                l = mid + 1
    return nums[l]

print(findMin([10, 1, 10, 10, 10]))