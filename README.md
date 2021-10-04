# SorterApp

An program that sorts an array of randomly generated integers. Contains both a command-line interface and a GUI application.

![sorterapp_thumb](https://user-images.githubusercontent.com/11021728/135925326-50de863b-4d4e-41c7-8089-197c026c624d.PNG)

---

### User Interface

The GUI allows the user to enter their own array instead of generating one randomly. The array must contain ints only and each element must be separated with either a space or a comma.

Valid formats:
> `9 8 7 6 5 4 3 2 1`
> 
> `9,8,7,6,5,4,3,2,1`
> 
> `9, 8, 7, 6, 5, 4, 3, 2, 1`

---

### Sorting Algorithms
The following sorting algorithms are currently implemented:
- Bubble sort
- Merge sort
- Quick sort
- Binary tree sort

---

### User Requirements
1. Client is presented with a number of sort algorithms to choose from
2. Decision is given via the command line (Scanner)
3. The program will then ask for the length of an array again via the command line (Scanner)
4. The program should then output:
	- The unsorted randomly generated array
	- The sort algorithm to be used
	- The sorted array after the algorithm has been executed
	- The time taken


---

### To-Do

- [ ] Allow user to specify range when generating a random array
- [ ] Implement alternative methods for choosing a pivot during quick sort
- [ ] Detect non-numeric, non-comma characters in the GUI array input field and disable Sort button if there are
- [ ] Implement more sort algorithms (insertion, selection, Collections.sort(), Arrays.sort(), Arrays.p barallelSort())
- [ ] Add an option for the user to use all or a combination of search approaches to allow a performance comparison of sort methods to be made
