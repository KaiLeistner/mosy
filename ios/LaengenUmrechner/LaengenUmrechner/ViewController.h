//
//  ViewController.h
//  LaengenUmrechner
//
//  Created by Andreas on 28.03.14.
//  Copyright (c) 2014 Andreas. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController <UIPickerViewDataSource, UIPickerViewDelegate>
@property (weak, nonatomic) IBOutlet UITextField *sourceField;
@property (weak, nonatomic) IBOutlet UILabel *destinationField;
@property (weak, nonatomic) IBOutlet UIPickerView *sourceUnit;
@property (weak, nonatomic) IBOutlet UIPickerView *destinationUnit;

@end
