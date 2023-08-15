import React from 'react'

const HomeSectionCard = () => {
  return (
    <div className='cursor-pointer flex flex-col items-center bg-white rounded-lg shadow-lg overflow-hidden w-[15rem] mx-3'>
        <div className='h-[13rem] w-[10rem]'>
            <img className='object-cover object-top w-full h-full' src="https://s3no.cashify.in/cashify/product/img/xxhdpi/d8394bf8-e922.jpg?p=es3sq&s=es" alt="" />
        </div>

        <div className='p-4'>
            <h3 className='text-lg font-medium text-grey-900'>Apple iPhone 11 - Refurbished</h3>
            <p className='mt-2 text-sm text-grey-500'>Fair, 4 GB / 64 GB, Black</p>
        </div>
    </div>
  )
}

export default HomeSectionCard