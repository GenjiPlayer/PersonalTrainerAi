"use client";
import { useState } from 'react';
import AgeHeightWeight from "@/components/AgeHeightWeight";
import IntroQuestion from "@/components/IntroQuestion";

export default function Home() {
    const [step, setStep] = useState(0);
    const [userData, setUserData] = useState({
        gymProficiency: '',
        age: '',
        height: '',
        goalWeight: '',
        currentWeight: '',
    });

    const handleNextStep = async (data) => {
        setUserData((prevData) => ({ ...prevData, ...data }));
        setStep(step + 1);
    };

    const handleSubmit = async () => {
        try {
            const response = await fetch('http://localhost:8080/input/submit', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(userData),
            });
            const result = await response.json();
            console.log('Response from backend:', result);
        } catch (error) {
            console.error('Error submitting data:', error);
        }
    };

    return (
        <div className="flex flex-col items-center justify-center min-h-screen p-4 bg-gray-100 text-gray-800">
            <h1 className="text-3xl font-bold mb-8">Welcome to Gym Tracker</h1>
            <div className="bg-white p-6 rounded-lg shadow-md w-full max-w-md">
                {step === 0 && <IntroQuestion onNext={handleNextStep} />}
                {step === 1 && <AgeHeightWeight onNext={handleNextStep} gymProficiency={userData.gymProficiency} />} {/* Pass gymProficiency */}
                {step === 2 && (
                    <div>
                        <h2 className="text-xl font-semibold mb-4">Review Your Data</h2>
                        <pre className="bg-gray-200 p-4 rounded mb-4">{JSON.stringify(userData, null, 2)}</pre>
                        <button
                            onClick={handleSubmit}
                            className="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
                        >
                            Submit
                        </button>
                    </div>
                )}
            </div>
        </div>
    );
}