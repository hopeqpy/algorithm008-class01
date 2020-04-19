package three;

class RemoveDuplicationFromSortedArray{

    public int removeDuplicates(int [] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int temp = nums[0];
        int count = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i]>temp){
                temp=nums[i];
                count++;
                nums[count-1]=temp;
            }else{
                continue;
            }
        }
        return count;
    }

}