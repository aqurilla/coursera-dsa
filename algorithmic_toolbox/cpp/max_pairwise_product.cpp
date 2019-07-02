#include <iostream>
#include <vector>

using std::vector;
using std::cin;
using std::cout;

long long MaxPairwiseProduct(const vector<int> &numbers) {
  long long max1 = 0;
  long long max2 = 0;
  long long result = 0;
  if (numbers.size()==1) {
    return ((long long)numbers[0]);
  }
  else if (numbers.size()==2) {
    return ((long long)numbers[0]*numbers[1]);
  }
  else {
    for (int i=0; i<numbers.size(); i++){
      if ((long long)numbers[i]>=max1) {
        max2 = max1;
        max1 = numbers[i];
      }
    }
  }
  result = max1*max2;
  return result;
}

int main() {
  int n;
  cin >> n;

  if (n==0) {
    cout << 0 << "\n";
    return 0;
  }

  vector<int> numbers(n);

  for (int i=0; i<n; i++) {
    cin >> numbers[i];
  }

  long long result = MaxPairwiseProduct(numbers);
  cout << result << "\n";
  return 0;
}
