//SYSTEM ADMIN TASK_1

//To change the date to two days before 
sudo date -s "Wed May 25 11:06:25 IST 2016"

//To create a new directory
mkdir My_dir

//To create 100 files
touch file{1..100}.txt

//To set the size of all the files as 10kb
for x in {1..100}; do dd if=/dev/zero of=./file$x.txt bs=1024 count=10; done

//To randomly alot 16 characters to each of the file
charSet="[alnum]"
for x in {1..100}; do cat /dev/urandom |tr -cd '$charSet'| fold -w 16 | head -n 1 > ./file$x.txt; done

//To modify the access of the files as read-only
for x in {1..100}; do chmod 400 ./file$x.txt; done