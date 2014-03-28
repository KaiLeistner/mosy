//
//  ViewController.h
//  RGBSlider
//
//  Created by Andreas on 19.03.13.
//  Copyright (c) 2013 Andreas. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
@property (weak, nonatomic) IBOutlet UISlider *sliderRed;
@property (weak, nonatomic) IBOutlet UISlider *sliderGreen;
@property (weak, nonatomic) IBOutlet UISlider *sliderBlue;
- (IBAction)sliderChanged:(id)sender;

@end
