//SYSTEM ADMIN TASK_1

//To create a new directory
mkdir My_dir

//To create 100 files
touch file{1..100}.txt

charSet="[alnum]"
//To set the size of all the files as 10kb
//To set the size of all the files as 10kb file
//To modify the access of the files as read-only
// To change the date of creation

for x in {1..100}; 
do 
dd if=/dev/zero of=./file$x.txt bs=1024 count=10;
cat /dev/urandom |tr -cd '$charSet'| fold -w 16 | head -n 1 > ./file$x.txt; 
chmod 400 ./file$x.txt; 
touch -d "2 days ago" ./file$x.txt;  
done
