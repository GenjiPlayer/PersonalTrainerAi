import { useState } from 'react';

export default function IntroQuestion({ onNext }) {
    const [gymProficiency, setGymProficiency] = useState('');

    const handleNext = () => {
        onNext({ gymProficiency });
    };

    return (
        <div>
            <h2 className="text-lg font-medium mb-4">Choose Your Experience Level:</h2>
            <div className="space-y-2">
                <select
                    value={gymProficiency}
                    onChange={(e) => setGymProficiency(e.target.value)}
                    className="w-full border border-gray-300 rounded px-3 py-2"
                >
                    <option value="">Select Experience Level</option>
                    <option value="beginner">Beginner</option>
                    <option value="intermediate">Intermediate</option>
                    <option value="expert">Expert</option>
                </select>
                <button
                    onClick={handleNext}
                    disabled={!gymProficiency}
                    className="mt-4 w-full bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
                >
                    Next
                </button>
            </div>
        </div>
    );
}