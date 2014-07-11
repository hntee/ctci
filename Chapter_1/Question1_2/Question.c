#include <stdio.h>

void reverse(char * str) {
	if (!(*str)) return;
	char * left = str;
	char * right = str;

	while (*right) {
	    right++;
	}
	right--;

	while (left < right) {
		// swap
		char tmp = *left;
		*left = *right;
		*right = tmp;

		left++;
		right--;
	}
}

int main() {
	char s1[] = "qwert";
	char s2[] = "z";
	char s3[] = "\0\0\0";

	reverse(s1);
	reverse(s2);
	reverse(s3);

	printf("%s\n", s1);
	printf("%s\n", s2);
	printf("%s\n", s3);
}