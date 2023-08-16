import { IconButton, Button } from "@mui/material";
import RemoveCircleOutlineIcon from "@mui/icons-material/RemoveCircleOutline";
import AddCircleOutlineIcon from "@mui/icons-material/AddCircleOutline";
import React from "react";

const CartItem = () => {
  return (
    <div className="p-5 shadow-lg border rounded-md">
      <div className="flex item-center">
        <div className="w-[5rem] h-[5rem] lg:w-[9rem] lg:h-[9rem]">
          <img
            className="w-full h-full object-cover object-top"
            src="https://s3no.cashify.in/pd-admin/0dd08bf895b3439684c8db2675e29f98.jpeg?p=es5sq&s=es"
            alt=""
          />
        </div>

        <div className="ml-5 space-y-1">
          <p className="font-semibold">Apple iPhone XR - Refurbished</p>
          <p className="opacity-70">Fair, 3 GB / 64 GB, Black</p>
          <p className="opacity-70 mt-2">Seller: Apple iphone</p>

          <div className="flex space-x-5 items-center text-gray-900 mt-6 pt-3">
            <p className="font-semibold">₹32,399</p>
            <p className="opacity-50 line-through">₹64,900</p>
            <p className="text-green-600 font-semibold">50% Off</p>
          </div>
        </div>
      </div>

      <div className="lg:flex items-center lg:space-x-10 pt-4">
        <div className="flex items-center space-x-2">
          <IconButton>
            <RemoveCircleOutlineIcon />
          </IconButton>

          <span className="py-1 px-7 border rounded-sm">1</span>
          <IconButton sx={{color:"RGB(145 85 253)"}}>
            <AddCircleOutlineIcon />
          </IconButton>
        </div>

        <div>
          <Button sx={{color:"RGB(145 85 253)"}} >Remove</Button>
        </div>
      </div>
    </div>
  );
};

export default CartItem;
