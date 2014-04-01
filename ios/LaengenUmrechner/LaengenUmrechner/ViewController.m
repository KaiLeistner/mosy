//
//  ViewController.m
//  LaengenUmrechner
//
//  Created by Andreas on 28.03.14.
//  Copyright (c) 2014 Andreas. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

const double conversionFactors[] = {1, 1000, 1852, 9460730472580.8};
NSString* titles[] = {@"Meter", @"Kilometer", @"Seemeile", @"Lichtjahr"};



@implementation ViewController {
    
}


- (void)viewDidLoad
{
    [super viewDidLoad];
 
// number pad has no "Done" kay; this code adds UIToolbar above keyboard using inputaccesoryview
// http://stackoverflow.com/questions/3014964/how-to-show-button-done-on-number-pad-on-iphone-os-4
    
    UIToolbar* toolbar = [[UIToolbar alloc]initWithFrame:CGRectMake(0, 0, 320, 50)];
    
    toolbar.items = [NSArray arrayWithObjects:
                           [[UIBarButtonItem alloc]initWithTitle:@"Cancel" style:UIBarButtonItemStyleBordered target:self action:@selector(cancelNumberPad)],
                           [[UIBarButtonItem alloc]initWithBarButtonSystemItem:UIBarButtonSystemItemFlexibleSpace target:nil action:nil],
                           [[UIBarButtonItem alloc]initWithTitle:@"Apply" style:UIBarButtonItemStyleDone target:self action:@selector(doneWithNumberPad)],
                           nil];
    self.sourceField.inputAccessoryView = toolbar;

	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

// UIPickerViewDataSource
-(NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView{
    return 1;
}
-(NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component{
    return sizeof(titles)/sizeof(NSString*);
}
//UIPickerViewDelegate
-(NSString*)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component{
    return titles[row];
}
-(void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component{
    [self convert];
}

-(void) doneWithNumberPad{
    [self.sourceField resignFirstResponder];
    [self convert];
}
-(void)cancelNumberPad{
    [self.sourceField resignFirstResponder];
    self.sourceField.text = @"";

}
-(void)convert{
    int index1 = [self.sourceUnit selectedRowInComponent:0];
    double factor1 = conversionFactors[index1];
    int index2 = [self.destinationUnit selectedRowInComponent:0];
    double factor2 = conversionFactors[index2];
    
    double sourceValue = [self.sourceField.text doubleValue];
    double destinationValue = sourceValue * factor1 / factor2;
    
    self.destinationField.text = [NSString stringWithFormat:@"%g",  destinationValue];
}

@end
