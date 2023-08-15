export const filters = [
  {
    id: 'brand',
    name: 'Brand',
    options: [
      { value: 'apple', label: 'Apple', checked: true },
      { value: 'google', label: 'Google', checked: false },
      { value: 'motorola', label: 'Motorola', checked: false },
      { value: 'oneplus', label: 'OnePlus', checked: false },
      { value: 'oppo', label: 'Oppo', checked: false },
      { value: 'poco', label: 'Poco', checked: false },
      { value: 'realme', label: 'Realme', checked: false },
      { value: 'samsung', label: 'Samsung', checked: false },
    ],
  },
  {
    id: 'ram',
    name: 'RAM',
    options: [
      { value: '4gb', label: '4 GB', checked: true },
      { value: '8gb', label: '8 GB', checked: false },
      { value: '16gb', label: '16 GB', checked: false },
    ],
  },
  {
    id: 'storage',
    name: 'Storage',
    options: [
      { value: '64gb', label: '64 GB', checked: false },
      { value: '128gb', label: '128 GB', checked: false },
      { value: '256gb', label: '256 GB', checked: false },
      { value: '512gb', label: '512 GB', checked: false },
      { value: '1tb', label: '1 TB', checked: false },
    ],
  },
  {
    id: 'battery',
    name: 'Battery Capacity',
    options: [
      { value: '3000mah', label: '3000 mAh', checked: false },
      { value: '3500mah', label: '3500 mAh', checked: false },
      { value: '4000mah', label: '4000 mAh', checked: false },
      { value: '4500mah', label: '4500 mAh', checked: false },
      { value: '5000mah', label: '5000 mAh', checked: false },
      { value: '6000mah', label: '6000 mAh', checked: false },
    ],
  },
];

export const singleFilter=[
  {
    id: 'price',
    name: 'Price',
    options: [
      { value: '5999-7999', label: '₹5999 To ₹7999', checked: false },
      { value: '7999-9999', label: '₹7999 To ₹7999', checked: false },
      { value: '9999-12999', label: '₹9999 To ₹12999', checked: false },
      { value: '12999-15999', label: '₹12999 To ₹15999', checked: false },
      { value: '15999-19999', label: '₹15999 To ₹19999', checked: false },
      { value: 'above19999', label: '19999 And Above', checked: false },
    ],
  },
  {
    id: 'dicount',
    name: 'Discount Range',
    options: [
      { value: '10%', label: '10% And Above', checked: false },
      { value: '20%', label: '20% And Above', checked: false },
      { value: '30%', label: '30% And Above', checked: false },
      { value: '40%', label: '40% And Above', checked: false },
      { value: '50%', label: '50% And Above', checked: false },
      { value: '60%', label: '60% And Above', checked: false },
      { value: '70%', label: '70% And Above', checked: false },
      { value: '80%', label: '80% And Above', checked: false },
    ],
  },
  {
    id: 'stock',
    name: 'Availability',
    options: [
      { value: 'in_stock%', label: 'In Stock', checked: false },
      { value: 'out_of_stock', label: 'Out Of Stock', checked: false },
    ],
  },
]